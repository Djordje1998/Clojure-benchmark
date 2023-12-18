(ns benchmark.mesurements
  (:require [criterium.core :refer :all]
            [benchmark.core :refer :all]))

(def n (doall (range 1 1e6)))
(def nd (double-array n))
(quick-bench (count n))                                     ;  37,408835 ms
(quick-bench (count nd))                                    ;  58,474716 ns

; Average benchmark

(avg-reduce n)
(quick-bench (avg-reduce n))                                ;  46,381846 ms

(avg-loop-rec n)
(quick-bench (avg-loop-rec n))                              ;  22,371506 ms

(avg-areduce nd)
(quick-bench (avg-areduce nd))                              ; 733,582998 µs

(avg-loop-rec-array nd)
(quick-bench (avg-loop-rec-array nd))                       ; 728,138070 µs

; Standard deviation benchmark

(std-dev-reduce n)
(quick-bench (std-dev-reduce n))                            ;  89,611946 ms

(std-dev-loop-rec n)
(quick-bench (std-dev-loop-rec n))                          ;  66,459096 ms

(std-dev-areduce nd)
(quick-bench (std-dev-areduce nd))                          ;   1,483616 ms

(std-dev-loop-rec-array nd)
(quick-bench (std-dev-loop-rec-array nd))                   ;   1,485625 ms

; dot product benchmark

(dot-product-loop-rec nd nd)
(quick-bench (dot-product-loop-rec nd nd))                  ;  30,556188 ms

(dot-product-loop-rec-array nd nd)
(quick-bench (dot-product-loop-rec-array nd nd))            ; 751,898635 µs

