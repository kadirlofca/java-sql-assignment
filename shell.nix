{ pkgs ? import <nixpkgs> {config.allowUnfree = true;} }:

pkgs.mkShell {
  buildInputs = [
    (pkgs.vscode-with-extensions.override {
      vscodeExtensions = with pkgs.vscode-extensions; [
        visualstudioexptteam.vscodeintellicode
        vscjava.vscode-java-pack
        vscjava.vscode-maven
        vscjava.vscode-java-debug
        redhat.java
      ];
    })
  ];

  nativeBuildInputs = with pkgs; [
    jdk
    maven
  ];
}
