# tuition-fee-calc
Calculate my tuition fee in a semester, doing under OOP Java.

VNUHCM - University of Science, Spring 2021.

## what it will do
Calculate semester tuition fee in a `.csv` file.

## how to
### install
```shell
$ git clone
```

- Note: Make sure you have at least Java JDK 8.
### input format
The .csv input file should looks like this:
|          class name         | class credit | lab credit |
|-----------------------------|--------------|------------|
| Object Oriented Programming |      3       |      1     |
| Java Programming            |      3       |      1     |
| Calculus 1                  |      3       |      0     |
| Calculus 1 (Lab)            |      0       |      1     |
| ...                         |              |            |

### Credit cost configuration
- Rename `tuition-fee-calc.config.example` to `tuition-fee-calc.config`:
```shell
$ cp tuition-fee-calc.config.example tuition-fee-calc.config
```

- Edit `tuition-fee-calc.config`.
### Command-line
```shell
$ java src/Main.java <INPUT_FILE.csv> <OUTPUT_FILE.csv> 
```
### Shell scripts
- Rename `compile.sh.example` and `run.sh.example`:
```shell
$ cp compile.sh.example compile.sh
$ cp run.sh.example run.sh
```

- Grant permissions:
```shell
$ chmod 0700 compile.sh run.sh
```

- Compile:
```shell
$ ./compile.sh
```

- Edit `run.sh`
- Run:
```shell
$ ./run.sh
```