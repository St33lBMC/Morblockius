srcDir := "./src"
buildDir := "./build"
compileDir := buildDir / "compiled"
jarLocation := buildDir / "build.jar"
manifestLocation := "./MANIFEST.MF"


libsDir := "./libs"

classPath := libsDir / "lwjgl/lwjgl.jar" + ":" +      libsDir / "lwjgl/lwjgl-glfw.jar"

mainFile := "./src/com/morblockius/Main.java"


run: build
    java -jar build/build.jar

build: makeDirs compile pack



makeDirs:
    mkdir -p {{compileDir}}

compile:
    javac -cp {{classPath}} -sourcepath {{srcDir}} -d {{compileDir}} {{mainFile}}

pack:
    jar cmf {{manifestLocation}}  {{jarLocation}} -C {{compileDir}} .

