# tuition-fee-calc
[![Build Status](https://dev.azure.com/19120338/trhgquan/_apis/build/status/trhgquan.tuition-fee-calc?branchName=main)](https://dev.azure.com/19120338/trhgquan/_build/latest?definitionId=2&branchName=main)

Calculate my tuition fee in a semester, doing under OOP Java.

## what it will do
Calculate semester tuition fee in a `.csv` file.

## how to
### Important notice
- Make sure you have at least __Java JDK 8__.
- This program use command-line arguments, takes `.csv` input and output format.

### install
```shell
git clone
```

### input format
The .csv input file should looks like this:
|          class name         | class credit | lab credit |
|:----------------------------|:------------:|:----------:|
| Object Oriented Programming |      3       |      1     |
| Java Programming            |      3       |      1     |
| Calculus 1                  |      3       |      0     |
| Calculus 1 (Lab)            |      0       |      1     |
| ...                         |     ...      |     ...    |

### Credit cost configuration
- Rename `tuition-fee-calc.config.example` to `tuition-fee-calc.config`:
  ```shell
  cp tuition-fee-calc.config.example tuition-fee-calc.config
  ```

- Edit `tuition-fee-calc.config`:
  ```config
  tuition-fee-calc.class=COST_OF_ONE_CLASS_CREDIT
  tuition-fee-calc.lab=COST_OF_ONE_LAB_CREDIT
  ```

  Replace `COST_OF_ONE_CLASS_CREDIT` with __cost of class credit__, `COST_OF_ONE_LAB_CREDIT` with __cost of lab credit__.
### Command-line
```shell
java src/Main.java <INPUT_FILE.csv> <OUTPUT_FILE.csv> 
```
### Shell scripts
- Rename `compile.sh.example` and `run.sh.example`:
  ```shell
  cp compile.sh.example compile.sh
  cp run.sh.example run.sh
  ```

- Grant permissions:
  ```shell
  chmod 0700 compile.sh run.sh
  ```

- Compile:
  ```shell
  ./compile.sh
  ```

- Edit `run.sh`
- Run:
  ```shell
  ./run.sh
  ```