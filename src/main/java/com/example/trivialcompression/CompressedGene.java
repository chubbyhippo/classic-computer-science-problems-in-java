package com.example.trivialcompression;

import java.util.BitSet;

public class CompressedGene {

    private BitSet bitSet;
    private int length;

    public CompressedGene(String gene) {
        compress(gene);
    }

    private void compress(String gene) {
        length = gene.length();
        // reserve enough capacity for all of the bits
        bitSet = new BitSet(length * 2);
        // convert to upper case for consistency
        final String upperGene = gene.toUpperCase();
        // convert String to bit representation
        for (int i = 0; i < length; i++) {
            final int firstLocation = 2 * i;
            final int secondLocation = 2 * i + 1;
            switch (upperGene.charAt(i)) {
                case 'A' -> {
                    bitSet.set(firstLocation, false);
                    bitSet.set(secondLocation, false); // 00 are next two bits
                }
                case 'C' -> {
                    bitSet.set(firstLocation, false);
                    bitSet.set(secondLocation, true); // 01 are next two bits
                }
                case 'G' -> {
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation, false); // 10 are next two bits
                }
                case 'T' -> {
                    bitSet.set(firstLocation, true);
                    bitSet.set(secondLocation, true); // 11 are next two bits
                }
                default ->
                        throw new IllegalArgumentException("The provided gene String contains characters other than ACGT");
            }
        }
    }

    public String decompress() {
        if (bitSet == null) {
            return "";
        }
        // create a mutable place for characters with the right capacity
        var builder = new StringBuilder(length);
        for (int i = 0; i < (length * 2); i += 2) {
            final int firstBit = (bitSet.get(i) ? 1 : 0);
            final int secondBit = (bitSet.get(i + 1) ? 1 : 0);
            final int lastBits = firstBit << 1 | secondBit;
            switch (lastBits) {
                case 0b00: // 00 is 'A'
                    builder.append('A');
                    break;
                case 0b01: // 01 is 'C'
                    builder.append('C');
                    break;
                case 0b10: // 10 is 'G'
                    builder.append('G');
                    break;
                case 0b11: // 11 is 'T'
                    builder.append('T');
                    break;
                default:
                    throw new IllegalArgumentException("The provided gene String contains characters other than lastBits");
            }
        }
        return builder.toString();
    }
}
