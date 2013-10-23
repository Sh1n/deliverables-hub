package com.gmail.shinsensei.deliverablesHub.utils.to;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Francesco Bux
 */
public enum SystemUserType {
    STUDENT("STUDENT"), ADMIN("ADMIN"), PROFESSOR("PROFESSOR"), NOTYPE("NOTYPE");
    
    private static final Map<String, SystemUserType> nameLookup = new HashMap<String, SystemUserType>();
    private String name;
    SystemUserType(String name) {
        this.name = name;
    }

    static {
        for (SystemUserType s : EnumSet.allOf(SystemUserType.class)) {
                nameLookup.put(s.toString().toLowerCase(), s);
        }
    } 
    @Override
    public String toString() {
            return name;
    }
    
    public static SystemUserType lookup(String name) {
        return nameLookup.get(name.toLowerCase());
    }
}
