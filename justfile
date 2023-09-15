srcDir := "./src"
buildDir := "./build"
compileDir := buildDir / "compiled"
jarLocation := buildDir / "build.jar"
manifestLocation := "./MANIFEST.MF"


libsDir := "./libs"

classPath := "libs/lwjgl/natives/*:libs/lwjgl/*"

mainFile := "./src/com/morblockius/Main.java"


run: build
    java -classpath ".:./build/build.jar:libs/lwjgl/natives/*:libs/lwjgl/*" com.morblockius.Main  

build: makeDirs compile pack



makeDirs:
    mkdir -p {{compileDir}}

compile:
    javac -cp {{classPath}} -sourcepath {{srcDir}} -d {{compileDir}} {{mainFile}}

pack:
    jar cmf {{manifestLocation}}  {{jarLocation}} -C {{compileDir}} .

