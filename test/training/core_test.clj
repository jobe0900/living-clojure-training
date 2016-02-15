(ns training.core-test
  (:require [clojure.test :refer :all]
            [training.core :refer :all]))

;; Training program for book "Living Clojure"
;; Koans from 4clojure.com

;; #1
;; (= __ true)
(deftest test-1
  (testing "#1"
    (is (= true true))))

;; #2
;; (= (- 10 (* 2 3)) __)
(deftest test-2
  (testing "#2" 
    (is (= (- 10 (* 2 3)) 4))))


;;;; WEEK  1  ============================================================
;;;  DAY   1  ------------------------------------------------------------

;; #3
;; (= __ (.toUpperCase "hello world"))
(deftest test-3
  (testing "#3"
    (is (= "HELLO WORLD" (.toUpperCase "hello world")))))

;; #4
;; (= (list __) '(:a :b :c)) 
(deftest test-4
  (testing "#4"
    (is (= (list :a :b :c) '(:a :b :c)))))

;; #5
;; (= __ (conj '(2 3 4) 1))
;; (= __ (conj '(3 4) 2 1))
(deftest test-5-1
  (testing "#5-1"
    (is (= '(1 2 3 4) (conj '(2 3 4) 1)))
    (is (= '(1 2 3 4) (conj '(3 4) 2 1)))))

;; #6
;; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
(deftest test-6
  (testing "#6"
    (is (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))))

;; #7
;; (= __ (conj [1 2 3] 4))
;; (= __ (conj [1 2] 3 4))
(deftest test-7
  (testing "#7"
    (is (= [1 2 3 4] (conj [1 2 3] 4)))
    (is (= [1 2 3 4] (conj [1 2] 3 4)))))

;; #8
;; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
;; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))
(deftest test-8
  (testing "#8"
    (is (= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d))))
    (is (= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d})))))

;; #9
;; (= #{1 2 3 4} (conj #{1 4 3} __))
(deftest test-9
  (testing "#9"
    (is (= #{1 2 3 4} (conj #{1 4 3} 2)))))

;; #10
;; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
;; (= __ (:b {:a 10, :b 20, :c 30}))
(deftest test-10
  (testing "#10"
    (is (= 20 ((hash-map :a 10, :b 20, :c 30) :b)))
    (is (= 20 (:b {:a 10, :b 20, :c 30})))))

;; #11
;; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
(deftest test-11
  (testing "#11"
    (is (= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3])))))

;; #12
;; (= __ (first '(3 2 1)))
;; (= __ (second [2 3 4]))
;; (= __ (last (list 1 2 3)))
(deftest test-12
  (testing "#12"
    (is (= 3 (first '(3 2 1))))
    (is (= 3 (second [2 3 4])))
    (is (= 3 (last (list 1 2 3))))))
