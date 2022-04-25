JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Driver.java \
	hw7/DayOfYearSet.java
	

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class