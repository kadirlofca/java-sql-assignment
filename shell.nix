{ pkgs ? import <nixpkgs> {config.allowUnfree = true;} }:

pkgs.mkShell {
  buildInputs = [
    (pkgs.vscode-with-extensions.override {
      vscodeExtensions = with pkgs.vscode-extensions; [
        visualstudioexptteam.vscodeintellicode
        vscjava.vscode-java-debug
        vscjava.vscode-java-pack
        vscjava.vscode-maven
        mechatroner.rainbow-csv
        redhat.java
      ];
    })
  ];

  nativeBuildInputs = with pkgs; [
    jdk
    maven
  ];
}
