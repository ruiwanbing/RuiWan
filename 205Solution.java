 public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        // 1:1 mapping but can chain
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> key = new HashSet<>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                // contains value not key
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }
        }
        return true;
    }