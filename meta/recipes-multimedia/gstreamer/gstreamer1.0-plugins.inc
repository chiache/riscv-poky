SUMMARY = "Plugins for the GStreamer multimedia framework 1.x"
HOMEPAGE = "http://gstreamer.freedesktop.org/"
BUGTRACKER = "https://bugzilla.gnome.org/enter_bug.cgi?product=Gstreamer"
SECTION = "multimedia"

DEPENDS = "gstreamer1.0 glib-2.0-native"

inherit autotools pkgconfig upstream-version-is-even

acpaths = "-I ${S}/common/m4 -I ${S}/m4"

LIBV = "1.0"
require gst-plugins-package.inc

PACKAGECONFIG[debug] = "--enable-debug,--disable-debug"
PACKAGECONFIG[orc] = "--enable-orc,--disable-orc,orc orc-native"
PACKAGECONFIG[valgrind] = "--enable-valgrind,--disable-valgrind,valgrind"

export ORCC = "${STAGING_DIR_NATIVE}${bindir}/orcc"

EXTRA_OECONF = " \
    --disable-examples \
"

PACKAGES_DYNAMIC = "^${PN}-.*"
