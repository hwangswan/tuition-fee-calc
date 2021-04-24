# tuition-fee-calc
Calculate my tuition fee in a semester, doing under OOP Java.

VNUHCM - University of Science, Spring 2021.

## what it will do
Calculate semester tuition fee in a .csv file.

## how to
### install
1. make sure you have java jdk 8. 
2. `git clone`
3. grand permissions for `compile.sh`: `chmod 0700 compile.sh`
4. compile: `./compile.sh`

### input format
The .csv input file should looks like this:
|          class name         | class credit | lab credit |
|-----------------------------|--------------|------------|
| Object Oriented Programming |      3       |      1     |
| Java Programming            |      3       |      1     |
| Calculus 1                  |      3       |      0     |
| Calculus 1 (Lab)            |      0       |      1     |
| ...                         |              |            |

### run
1. Edit `run.sh`, replace `INPUT` with your input .csv file and `OUTPUT` with your output .csv file.
2. `./run.sh`
