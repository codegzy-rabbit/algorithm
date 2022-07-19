package class08;

import java.util.HashMap;

/**
 * O(1)情况下获取一个值，删除一个值和获取一个随机值
 */

public class HashRandom {
    public static void main(String[] args) {

    }

    public class Hash<K> {
        private HashMap<K, Integer> kIntegerHashMap;
        private HashMap<Integer, K> integerKHashMap;
        private int size;

        public Hash() {
            kIntegerHashMap = new HashMap<>();
            integerKHashMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key) {
            if (!this.kIntegerHashMap.containsKey(key)) {
                this.kIntegerHashMap.put(key, this.size);
                this.integerKHashMap.put(this.size++, key);
            }
        }

        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * size);
            return this.integerKHashMap.get(randomIndex);
        }

        public void delete(K key) {
            if (kIntegerHashMap.containsKey(key)) {
                Integer deleteIndex = this.kIntegerHashMap.get(key);
                int lastIndex = --this.size;
                K lastKey = this.integerKHashMap.get(lastIndex);
                this.kIntegerHashMap.put(lastKey, deleteIndex);
                this.integerKHashMap.put(deleteIndex, lastKey);
                this.kIntegerHashMap.remove(key);
                this.integerKHashMap.remove(lastIndex);
            }
        }

    }
}
