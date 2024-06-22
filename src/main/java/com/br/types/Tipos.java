package com.br.types;

public enum Tipos {
    CREATE("CREATE"),
    ALTER("ALTER");
    private String value;

    Tipos(String value) {
        this.value = value;
    }

    public String getDesc() {
        return this.value;
    }
}
