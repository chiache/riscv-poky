SUMMARY = "RISC-V Spike ISA Simulator"
DESCRIPTION = "RISC-V Spike ISA Simulator"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRCREV = "0716eb14d784a9e7d1c63033c4b658de1d8c86ad"
SRC_URI = "git://github.com/chiache/riscv-isa-sim.git;branch=cache_trace;destsuffix=${S} \
           file://spike-rpath.patch \
           file://spike-makefile.patch"

DEPENDS = "riscv-fesvr dtc-native coreutils-native"
RDEPENDS_${PN}_class-nativesdk = "nativesdk-riscv-fesvr"

FILES_${PN} += "${libdir}/libriscv.so ${libdir}/libsoftfloat.so ${libdir}/libspike_main.so ${libdir}/libdummy_rocc.so"

DEPENDS_append_class-nativesdk = " chrpath-replacement-native"
EXTRANATIVEPATH_append_class-nativesdk = " chrpath-native"

EXTRA_OECONF_class-nativesdk = "--with-fesvr=${STAGING_DIR_HOST}${libdir}/../.."

INSANE_SKIP_${PN}-dev = "dev-elf"

inherit autotools

BBCLASSEXTEND = "native nativesdk"

S = "${WORKDIR}/git"

do_configure_prepend () {
	touch ${S}/softfloat/softfloat.ac
        if [ ! -e ${S}/acinclude.m4 ]; then
                cp ${S}/aclocal.m4 ${S}/acinclude.m4
        fi
}

# TODO: As soon as Spike is used again, fix the RPATHS
#INSANE_SKIP_${PN} = "rpaths"

do_compile_append() {
        chrpath -d ${B}/spike
        chrpath -d ${B}/spike-dasm
        chrpath -d ${B}/xspike
        chrpath -d ${B}/termios-xspike
        chrpath -d ${B}/libdummy_rocc.so
        chrpath -d ${B}/libriscv.so
        chrpath -d ${B}/libspike_main.so
        chrpath -d ${B}/libsoftfloat.so
}

do_package_qa() {
}
