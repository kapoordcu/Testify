package com.testify;


class HashTableEntry {
    private static final int DEFAULT_SIZE = 16;
    Integer key;
    Integer[] entries;

    public HashTableEntry() {
        entries = new Integer[DEFAULT_SIZE];
    }

    public HashTableEntry(Integer key) {
        this.key = key;
        entries = new Integer[DEFAULT_SIZE];
    }
}

public class MyHashTable {
    private HashTableEntry bucket[];

    public MyHashTable() {
        bucket = new HashTableEntry[16];
        for(int i=0; i<bucket.length; i++) {
            bucket[i] = new HashTableEntry();
        }
    }

    public int hash(Integer value) {
        return value.hashCode();
    }

    public void put(Integer key, Integer value) {
        int filledBuckets = 0;
        int hash = hash(key);
        int index = hash % (bucket.length);
        HashTableEntry entry = bucket[index];
        if(entry.key == null) {
            bucket[index-1] = new HashTableEntry(key);
            bucket[index-1].entries[0] = value;
        } else {
            for(Integer val: entry.entries) {
                filledBuckets++;
                if(val == null) {
                    bucket[index].entries[val] = value;
                } else {
                    bucket[index].entries[filledBuckets] = value;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.put(1, 39);
        myHashTable.put(2, 40);
        myHashTable.put(2, 101);
        System.out.println(myHashTable);
    }
}
