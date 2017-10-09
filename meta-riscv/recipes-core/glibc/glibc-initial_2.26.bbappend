python () {
    if d.getVar("TARGET_ARCH").find("riscv") >= 0:
        d.setVar("GLIBC_GIT_URI", "git://github.com/chiache/riscv-glibc")
        d.setVar("SRCBRANCH", "match-with-firesim")
        d.setVar("SRCREV", "e20d585599ac9969e5dc36c868310fd239918579")
}

GLIBC_ADDONS := ""

EXTRA_OECONF_remove = "--enable-add-ons"
