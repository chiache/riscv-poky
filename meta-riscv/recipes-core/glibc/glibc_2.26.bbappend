python () {
    if d.getVar("TARGET_ARCH").find("riscv") >= 0:
        d.setVar("GLIBC_GIT_URI", "git://github.com/chiache/riscv-glibc")
        d.setVar("SRCBRANCH", "match-with-firesim")
        d.setVar("SRCREV", "444c08ffc1a775ab365cf1f8e36b98c6e684eae6")
}

EXTRA_OECONF_remove = "--enable-add-ons"

SELECTED_OPTIMIZATION_append = "-Wno-error"
