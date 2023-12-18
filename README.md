# Benchmark

A Clojure library designed to ... well, that part is up to you.

## Usage

## Benchmark Results

### Average Calculations
| Function                     | Execution Time       |
|------------------------------|----------------------|
| `count` on `n`               | 37.41 ms             |
| `count` on `nd`              | 58.47 ns             |
| `avg-reduce` on `n`          | 46.38 ms             |
| `avg-loop-rec` on `n`        | 22.37 ms             |
| `avg-areduce` on `nd`        | 733.58 µs            |
| `avg-loop-rec-array` on `nd` | 728.14 µs            |

### Standard Deviation Calculations
| Function                       | Execution Time       |
|--------------------------------|----------------------|
| `std-dev-reduce` on `n`        | 89.61 ms             |
| `std-dev-loop-rec` on `n`      | 66.46 ms             |
| `std-dev-areduce` on `nd`      | 1.48 ms              |
| `std-dev-loop-rec-array` on `nd` | 1.49 ms           |

### Dot Product Calculations
| Function                           | Execution Time       |
|------------------------------------|----------------------|
| `dot-product-loop-rec` on `nd`     | 30.56 ms             |
| `dot-product-loop-rec-array` on `nd` | 751.90 µs        |



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
