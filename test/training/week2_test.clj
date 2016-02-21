(ns training.week2-test
  (:require [clojure.test :refer :all]))

;;;; WEEK  2  ============================================================
;;;  DAY   1  ------------------------------------------------------------

;; #26
;; (= (__ 3) '(1 1 2))
;; (= (__ 6) '(1 1 2 3 5 8))
;; (= (__ 8) '(1 1 2 3 5 8 13 21))
(defn func-26 [n]
  (take n (map last (iterate (fn [[a b]] [b (+ a b)]) [0 1]))))
(deftest test-26
  (testing "#26"
    (is (= (func-26 3) '(1 1 2)))
    (is (= (func-26 6) '(1 1 2 3 5 8)))
    (is (= (func-26 8) '(1 1 2 3 5 8 13 21)))))

;; #29
;; (= (__ "HeLlO, WoRlD!") "HLOWRD")
;; (empty? (__ "nothing"))
;; (= (__ "$#A(*&987Zf") "AZ")
(defn func-29 [s]
  (apply str (filter #(Character/isUpperCase %) s)))
(deftest test-29
  (testing "#29"
    (is (= (func-29 "HeLlO, WoRlD!") "HLOWRD"))
    (is (empty? (func-29 "nothing")))
    (is (= (func-29 "$#A(*&987Zf") "AZ"))))

;; #48
;; (= __ (some #{2 7 6} [5 6 7 8]))
;; (= __ (some #(when (even? %) %) [5 6 7 8]))
(deftest test-48
  (testing "#48"
    (is (= 6 (some #{2 7 6} [5 6 7 8])))
    (is (= 6 (some #(when (even? %) %) [5 6 7 8])))))

;; #42
;; (= (__ 1) 1)
;; (= (__ 3) 6)
;; (= (__ 5) 120)
;; (= (__ 8) 40320)
(defn func-42 [n]
  (apply * (range 1 (inc n))))
(deftest test-42
  (testing "#42"
    (is (= (func-42 1) 1))
    (is (= (func-42 3) 6))
    (is (= (func-42 5) 120))
    (is (= (func-42 8) 40320))))

;; #52
;; (= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))
(deftest test-52
  (testing "#52"
    (is (= [2 4] (let [[a b c d e] [0 1 2 3 4]] [c e])))))


;;;  DAY   2  ------------------------------------------------------------

;; #51
;; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))
(deftest test-51
  (testing "#51"
    (is (= [1 2 [3 4 5] [1 2 3 4 5]] 
           (let [[a b & c :as d] [1 2 3 4 5 ]] [a b c d])))))

;; #83
;; (= false (__ false false))
;; (= true (__ true false))
;; (= false (__ true))
;; (= true (__ false true false))
;; (= false (__ true true true))
;; (= true (__ true true true false))
(defn func-83 [& args]
  (and (not (= nil (some true? args))) (not (every? true? args))))
(deftest test-83
  (testing "#83"
    (is (= false (func-83 false false)))
    (is (= true (func-83 true false)))
    (is (= false (func-83 true)))
    (is (= true (func-83 false true false)))
    (is (= false (func-83 true true true)))
    (is (= true (func-83 true true true false)))))


;; #66
;; (= (__ 2 4) 2)
;; (= (__ 10 5) 5)
;; (= (__ 5 7) 1)
;; (= (__ 1023 858) 33)
(defn func-66 [x y]
  (if (zero? y)
    x
    (recur y (mod x y))))
(deftest test-66
  (testing "#66"
    (is (= (func-66 2 4) 2))
    (is (= (func-66 10 5) 5))
    (is (= (func-66 5 7) 1))
    (is (= (func-66 1023 858) 33))))
