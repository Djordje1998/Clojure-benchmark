(ns benchmark.core
  (:require [clojure.math :refer :all]))

(set! *warn-on-reflection* true)
(set! *unchecked-math* :warn-on-boxed)
(def n (doall (range 1 1e6)))
(def nd (double-array n))

; Average benchmark

;  46,381846 ms
(defn avg-reduce ^double [n]
  (/ ^double (reduce + n) (count n)))
(avg-reduce n)

;  22,371506 ms
(defn avg-loop-rec [n]
  (loop [sum 0.0 i 0 s (seq n)]
    (if s
      (recur (+ sum ^double (first s)) (inc i) (next s))
      (/ sum i))))
(avg-loop-rec n)

; 733,582998 µs
(defn avg-areduce [^doubles n]
  (/ (double (areduce n i acc 0.0 (+ acc (aget n i)))) (count n)))

(defn avg-areduce [^doubles n]
  (/ ^double (areduce n i acc 0.0 (+ acc (aget n i))) (count n)))
(avg-areduce nd)

; 728,138070 µs
(defn avg-loop-rec-array [^doubles n]
  (loop [sum 0.0 i 0 size (count n)]
    (if (< i size)
      (recur (+ sum ^double (aget n i)) (inc i) size)
      (/ sum i))))
(avg-loop-rec-array nd)

;(defn avg-loop-rec-array2 [^doubles n]
;  (loop [sum 0.0 i 0 s (seq n)]
;    (if s
;      (recur (+ sum ^double (first s)) (inc i) (next s))
;      (/ sum i))))
;
;(avg-loop-rec-array2 nd)

; Standard deviation benchmark

; 89,611946 ms
(defn std-dev-reduce ^double [n]
  (let [avg (avg-reduce n)]
    (sqrt (/ (reduce (fn [acc e]
                       (+ acc (pow (- avg e) 2))) 0.0 n) (count n)))))
(std-dev-reduce n)

; 66,459096 ms
(defn std-dev-loop-rec ^double [n]
  (let [avg (avg-reduce n)]
    (loop [sum 0.0
           i 0
           n (seq n)]
      (if n
        (recur (+ sum (pow (- avg (first n)) 2)) (inc i) (next n))
        (sqrt (/ sum i))))))
(std-dev-loop-rec n)

;  1,483616 ms
(defn std-dev-areduce ^double [^doubles n]
  (let [avg (avg-areduce n)]
    (sqrt (/ (areduce n idx ret 0.0 (+ ret (pow (- avg (aget n idx)) 2)))
             (count n)))))
(std-dev-areduce nd)

;  1,485625 ms
(defn std-dev-loop-rec-array ^double [^doubles n]
  (let [avg (avg-areduce n)]
    (loop [sum 0.0
           i 0
           size (count n)]
      (if (< i size)
        (recur (+ sum (pow (- avg (aget n i)) 2)) (inc i) size )
        (sqrt (/ sum size))))))
(std-dev-loop-rec-array nd)

; dot product

(defn dot-product-loop-rec ^double [n m]
  (loop [sum 0.0
         i 0
         s1 (seq n)
         s2 (seq m)]
    (if s1
      (recur (+ sum (* (first s1) (first s2))) (inc i) (next s1) (next s2))
      sum)))
(dot-product-loop-rec nd nd)

;  4,869953 ms
(defn dot-product-loop-rec-array ^double [^doubles n ^doubles m]
  (loop [sum 0.0
         i 0
         size (count n)]
    (if (< i size)
      (recur (+ sum (* (aget n i) (aget m i))) (inc i) size )
      sum)))
(dot-product-loop-rec-array nd nd)









































