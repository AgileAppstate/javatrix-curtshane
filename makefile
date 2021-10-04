#
# makefile 
#
# input file for 'make' build tool ( /usr/bin/make )
# to build solution for JUnit sample
#
# @author Dr. Fenwick
# @version Summer 2018
#

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml
SRC_DIR = ./javatrix

default: 
	@echo "usage: make target"
	@echo "example: make help"
	@echo "example: make targetlist"

help:
	@echo "Just starting with make? Try these 4 make commands successively:"
	@echo "________ make clean ; make compile ; make test ; make defchk"

targetlist:
	@echo "7 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile, test - builds JUnit5 tests, runs all (4 and 5)"
	@echo "____________________ defchk, customchk - default or custom checkstyle"
	@echo "____________________ help, targetlist - print usage and a list of targets"


# makefile syntax
#target-name: files dependent on (can use multiple lines by ending
#             lines with \
#<TAB char>Unix command-line command
#<TAB char>Unix command-line command
#etc.
#Essential that command lines start with single TAB character

compile: $(SRC_DIR)/Matrix.java MatrixTest.java Testtrix.java
	cd $(SRC_DIR); \
		javac -cp .:../$(JUNIT5_JAR) Matrix.java ../MatrixTest.java ../Testtrix.java

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path

defchk: $(SRC_DIR)/Matrix.java $(CKSTYLE_XML)
	java $(CKSTYLE_COMMAND) -c $(CKSTYLE_XML) $(SRC_DIR)/Matrix.java

customchk: $(SRC_DIR)/Matrix.java style.xml
	java $(CKSTYLE_COMMAND) -c style.xml $<

run:
	java Testtrix

clean:
	rm *.class $(SRC_DIR)/*.class

style.xml:
	@echo "Custom checkstyle needs a local style.xml file."
	@echo "Copy cs_appstate_checks.xml into style.xml and edit as needed."
	@echo "--------------------------------------------------------------"

