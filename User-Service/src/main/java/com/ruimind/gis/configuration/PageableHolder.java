package com.ruimind.gis.configuration;

import org.springframework.data.domain.Pageable;

public class PageableHolder {

    private static final ThreadLocal<Pageable> pageableHolder = new ThreadLocal<>();

    public static void setPageable(Pageable pageable) {
        pageableHolder.set(pageable);
    }

    public static Pageable getPageable() {
        return pageableHolder.get();
    }

    public static void clear() {
        pageableHolder.remove();
    }
}
