SUMMARY = "A small image just capable of allowing a device to boot."

DEPENDS += "riscv-pk riscv-spike-native"

#IMAGE_FEATURES += "package-management"

inherit core-image

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_BOOTSTRAP_INSTALL} ${CORE_IMAGE_EXTRA_INSTALL}"

# Basic packages
IMAGE_INSTALL += "apt libffi libffi-dev"

# Python
IMAGE_INSTALL += "python-numpy python-subprocess python-ctypes python-html python-netserver python-compile"

# Basic toolchain on target
IMAGE_INSTALL += "gcc binutils glibc glibc-dev libgcc libgcc-dev libstdc++ libstdc++-dev"

IMAGE_INSTALL += "sqlite3 sqlite-sample hunspell"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_ROOTFS_SIZE ?= "8192"
