(ns training.core-test
  (:require [clojure.test :refer :all]
            [training.core :refer :all]
            [clojure.set]))

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


;;;  DAY   2  ------------------------------------------------------------

;; #13
;; (= __ (rest [10 20 30 40]))
(deftest test-13
  (testing "#13"
    (is (= [20 30 40] (rest [10 20 30 40])))))

;; #14
;; (= __ ((fn add-five [x] (+ x 5)) 3))
;; (= __ ((fn [x] (+ x 5)) 3))
;; (= __ (#(+ % 5) 3))
;; (= __ ((partial + 5) 3))
(deftest test-14
  (testing "#14"
    (is (= 8 ((fn add-five [x] (+ x 5)) 3)))
    (is (= 8 ((fn [x] (+ x 5)) 3)))
    (is (= 8 (#(+ % 5) 3)))
    (is (= 8 ((partial + 5) 3)))))

;; #15
;; (= (__ 2) 4)
;; (= (__ 3) 6)
;; (= (__ 11) 22)
;; (= (__ 7) 14)
(deftest test-15
  (testing "#15"
    (is (= (#(* % 2) 2) 4))
    (is (= (#(* % 2) 3) 6))
    (is (= (#(* % 2) 11) 22))
    (is (= (#(* % 2) 7) 14))))

;; #16
;; (= (__ "Dave") "Hello, Dave!")
;; (= (__ "Jenn") "Hello, Jenn!")
;; (= (__ "Rhea") "Hello, Rhea!")
(deftest test-16
  (testing "#16"
    (is (= (#(str "Hello, " % "!") "Dave") "Hello, Dave!"))
    (is (= (#(str "Hello, " % "!") "Jenn") "Hello, Jenn!"))
    (is (= (#(str "Hello, " % "!") "Rhea") "Hello, Rhea!"))))

;; #17
;; (= __ (map #(+ % 5) '(1 2 3)))
(deftest test-17
  (testing "#17"
    (is (= '(6 7 8) (map #(+ % 5) '(1 2 3))))))

;; #18
;; (= __ (filter #(> % 5) '(3 4 5 6 7)))
(deftest test-18
  (testing "#18"
    (is (= '(6 7) (filter #(> % 5) '(3 4 5 6 7))))))

;; #35
;; (= __ (let [x 5] (+ 2 x)))
;; (= __ (let [x 3, y 10] (- y x)))
;; (= __ (let [x 21] (let [y 3] (/ x y))))
(deftest test-35
  (testing "#35"
    (is (= 7 (let [x 5] (+ 2 x))))
    (is (= 7 (let [x 3, y 10] (- y x))))
    (is (= 7 (let [x 21] (let [y 3] (/ x y)))))))


;; #36
;; (= 10 (let __ (+ x y)))
;; (= 4 (let __ (+ y z)))
;; (= 1 (let __ z))
(deftest test-36
  (testing "#36"
    (is (= 10 (let [x 7, y 3, z 1] (+ x y))))
    (is (= 4 (let [x 7, y 3, z 1] (+ y z))))
    (is (= 1 (let [x 7, y 3, z 1] z)))))
