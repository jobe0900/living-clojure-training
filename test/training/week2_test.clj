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

