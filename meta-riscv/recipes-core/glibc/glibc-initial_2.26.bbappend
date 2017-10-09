python () {
    if d.getVar("TARGET_ARCH").find("riscv") >= 0:
        d.setVar("GLIBC_GIT_URI", "git://github.com/chiache/riscv-glibc")
        d.setVar("SRCBRANCH", "match-with-firesim")
        d.setVar("SRCREV", "6badab50bf9c16b59ebf3924b553f391f83f06f1")
}

GLIBC_ADDONS := ""

EXTRA_OECONF_remove = "--enable-add-ons"
