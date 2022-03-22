# Opcode
Opcode is an esoteric language with an instruction set of size 2. 

## Language Description
The language contains only 2 instructions- `+` and `!` and all instructions are carried out using 8 opcodes. `+` command is used to change opcode counter and `!` is to execute the opcode. See [Esolang Wiki](https://esolangs.org/wiki/Opcode) for details.


## Files

### converter.py
Contains a function `convert` that takes any brainfu*k code and returns equivalent Opcode code.

### Interpreter.java
Contains classes required to run an Opcode code.

### Main.Java
Contains a sample code to use the Interpreter class and run Opcode codes.

## To-do

- [ ] Make a formal definition of the language so that an intermediate bf code is not required.
- [x] Write a BF to Opcode converter
- [x] Publish Esolang Wiki
- [ ] Misc 