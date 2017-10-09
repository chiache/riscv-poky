SUMMARY = "SQLite Sample Files"
HOMEPAGE = ""
LICENSE = "CLOSED"

SRC_URI = "file://2010CensusPopulation.db"

SRC_URI[md5sum] = "0ec273385f5bdb869919c5f20c4066f0"
SRC_URI[sha256sum] = "a0bba2480b3710a7854fd7c401679683fd044a7ff196e0e0b893c0ea4f3c8e25"

do_install() {
	install -d ${D}${datadir}/sqlite-sample
	install -m 0644 ${WORKDIR}/2010CensusPopulation.db ${D}${datadir}/sqlite-sample
}

FILES_${PN} += "${datadir}/sqlite-sample"
