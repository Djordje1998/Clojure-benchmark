# Benchmark

A Clojure library designed to ... well, that part is up to you.

## Usage

## Benchmark Results

### Count Calculations
| Function       | Execution Time | Improvement (%) | Speed Factor   |
|----------------|----------------|-----------------|----------------|
| `count` on `n` | 37.41 ms       | -               | -              |
| `count` on `nd`| 58.47 ns       | 99.84%          | x639.63        |

### Average Calculations
| Function                     | Execution Time | Improvement (%) | Speed Factor   |
|------------------------------|----------------|-----------------|----------------|
| `avg-reduce` on `n`          | 46.38 ms       | -               | -              |
| `avg-loop-rec` on `n`        | 22.37 ms       | 51.80%          | x2.07          |
| `avg-areduce` on `nd`        | 733.58 µs      | 98.42%          | x63.21         |
| `avg-loop-rec-array` on `nd` | 728.14 µs      | 98.43%          | x63.68         |

### Standard Deviation Calculations
| Function                       | Execution Time | Improvement (%) | Speed Factor   |
|--------------------------------|----------------|-----------------|----------------|
| `std-dev-reduce` on `n`        | 89.61 ms       | -               | -              |
| `std-dev-loop-rec` on `n`      | 66.46 ms       | 25.84%          | x1.35          |
| `std-dev-areduce` on `nd`      | 1.48 ms        | 98.35%          | x60.55         |
| `std-dev-loop-rec-array` on `nd` | 1.49 ms     | 98.34%          | x60.14         |

### Dot Product Calculations
| Function                           | Execution Time | Improvement (%) | Speed Factor   |
|------------------------------------|----------------|-----------------|----------------|
| `dot-product-loop-rec` on `nd`     | 30.56 ms       | -               | -              |
| `dot-product-loop-rec-array` on `nd` | 751.90 µs  | 97.54%          | x40.66         |



## License

Copyright © 2023 Đorđe Novaković

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
