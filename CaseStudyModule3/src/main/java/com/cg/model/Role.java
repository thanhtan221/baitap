package com.cg.model;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

        public static Role parseRole(String value) {
        Role[] values = values();
        for (Role role : values) {
            if (role.value == value)
                return role;

        }

        return null;
    }
//    public static Role parseStatus(int value) {
//        Role[] values = values();
//        for (Role st : values) {
//            if (st.value == value)
//                return st;
//        }
//        throw new IllegalArgumentException("value position invalid");
//    }

}
