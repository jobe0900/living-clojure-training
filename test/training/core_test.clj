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


;;;  DAY   3  ------------------------------------------------------------

;; #37
;; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
(deftest test-37
  (testing "#37"
    (is (= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce "))))))

;; #57
;; (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))
(deftest test-57
  (testing "#57"
    (is (= '(5 4 3 2 1)  ((fn foo [x] 
               (when (> x 0) 
                 (conj (foo (dec x)) x)))
             5)))))

;; #68
;; (= __
;;  (loop [x 5
;;         result []]
;;    (if (> x 0)
;;      (recur (dec x) (conj result (+ 2 x)))
;;      result)))
(deftest test-68
  (testing "#68"
    (is (=  [7 6 5 4 3] (loop [x 5 
                   result []] 
              (if (> x 0) 
                (recur (dec x) (conj result (+ 2 x))) 
                result))))))

;; #71
;; (= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
;;    (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
;;    5)
(deftest test-71
  (testing "#71"
    (is (= (last (sort (rest (reverse [2 5 4 1 3 6])))) 
           (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last)) 
           5))))

;; #72
;; (= (__ (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
;;    (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (__))
;;    11)
(deftest test-72
  (testing "#72"
    (is (= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6])))) 
           (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +)) 
           11))))

;; #145
;; (= __ (for [x (range 40)
;;             :when (= 1 (rem x 4))]
;;         x))
;;
;; (= __ (for [x (iterate #(+ 4 %) 0)
;;             :let [z (inc x)]
;;             :while (< z 40)]
;;         z))
;;
;; (= __ (for [[x y] (partition 2 (range 20))]
;;         (+ x y)))
(deftest test-145
  (testing "#145"
    (is (= [1 5 9 13 17 21 25 29 33 37] (for [x (range 40) 
                    :when (= 1 (rem x 4))] 
                x)))
    (is (= [1 5 9 13 17 21 25 29 33 37] (for [x (iterate #(+ 4 %) 0) 
                    :let [z (inc x)] 
                    :while (< z 40)] 
                z)))
    (is (= [1 5 9 13 17 21 25 29 33 37] (for [[x y] (partition 2 (range 20))] 
                (+ x y))))))


;;;  DAY   4  ------------------------------------------------------------

;; #20
;; (= (__ (list 1 2 3 4 5)) 4)
;; (= (__ ["a" "b" "c"]) "b")
;; (= (__ [[1 2] [3 4]]) [1 2])
(defn func-20 [coll]
  (first (rest (reverse coll))))
(deftest test-20 
  (testing "#20"
    (is (= (func-20 (list 1 2 3 4 5)) 4))
    (is (= (func-20 ["a" "b" "c"]) "b"))
    (is (= (func-20 [[1 2] [3 4]]) [1 2]))))

;; #24
;; (= (__ [1 2 3]) 6)
;; (= (__ (list 0 -2 5 5)) 8)
;; (= (__ #{4 2 1}) 7)
;; (= (__ '(0 0 -1)) -1)
;; (= (__ '(1 10 3)) 14)
(defn func-24 [coll]
  (reduce + coll))
(deftest test-24
  (testing "#24"
    (is (= (func-24 [1 2 3]) 6))
    (is (= (func-24 (list 0 -2 5 5)) 8))
    (is (= (func-24 #{4 2 1}) 7))
    (is (= (func-24 '(0 0 -1)) -1))
    (is (= (func-24 '(1 10 3)) 14))))

;; #25
;; (= (__ #{1 2 3 4 5}) '(1 3 5))
;; (= (__ [4 2 1 6]) '(1))
;; (= (__ [2 2 4 6]) '())
;; (= (__ [1 1 1 3]) '(1 1 1 3))
(defn func-25 [coll]
  (filter odd? coll))
(deftest test-25
  (testing "#25"
    (is (= (func-25 #{1 2 3 4 5}) '(1 3 5)))
    (is (= (func-25 [4 2 1 6]) '(1)))
    (is (= (func-25 [2 2 4 6]) '()))
    (is (= (func-25 [1 1 1 3]) '(1 1 1 3)))))

;; #27
;; (false? (__ '(1 2 3 4 5)))
;; (true? (__ "racecar"))
;; (true? (__ [:foo :bar :foo]))
;; (true? (__ '(1 1 3 3 1 1)))
;; (false? (__ '(:a :b :c)))
(defn func-27 [coll]
  (let [s (seq coll)]
    (= s (reverse s))))
(deftest test-27
  (testing "#27"
    (is (false? (func-27 '(1 2 3 4 5))))
    (is (true? (func-27 "racecar")))
    (is (true? (func-27 [:foo :bar :foo])))
    (is (true? (func-27 '(1 1 3 3 1 1))))
    (is (false? (func-27 '(:a :b :c))))))

;; #32
;; (= (__ [1 2 3]) '(1 1 2 2 3 3))
;; (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
;; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(defn func-32 [coll]
   (mapcat list coll coll))
(deftest test-32
  (testing "#32"
    (is (= (func-32 [1 2 3]) '(1 1 2 2 3 3)))
    (is (= (func-32 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
    (is (= (func-32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))))


;;;  DAY   5  ------------------------------------------------------------

;; #30
;; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
(defn func-30 [s]
  (loop [in s
         out []]
    (if (empty? in)
      out
      (recur (rest in)
             (if (= (first in) (last out))
               out
               (conj out (first in)))))))
(deftest test-30
  (testing "#30"
    (is (= (apply str (func-30 "Leeeeeerrroyyy")) "Leroy"))
    (is (= (func-30 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
    (is (= (func-30 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))))

;; #31
;; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
;; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
;; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
(defn func-31 [s]
  (partition-by identity s))
(deftest test-31
  (testing "#31"
    (is (= (func-31 [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
    (is (= (func-31 [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
    (is (= (func-31 [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))))

;; #41
;; (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
;; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
;; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
(defn func-41 [s nth]
  (flatten (partition-all (- nth 1) nth s)))
(deftest test-41
  (testing "#41"
    (is (= (func-41 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
    (is (= (func-41 [:a :b :c :d :e :f] 2) [:a :c :e]))
    (is (= (func-41 [1 2 3 4 5 6] 4) [1 2 3 5 6]))))

;; #45
;; (= __ (take 5 (iterate #(+ 3 %) 1)))
(deftest test-45
  (testing "#45"
    (is (= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1))))))

;; #33
;; (= (__ [1 2 3] 2) '(1 1 2 2 3 3))
;; (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
;; (= (__ [4 5 6] 1) '(4 5 6))
;; (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
;; (= (__ [44 33] 2) [44 44 33 33])
(defn func-33 [s n]
  (mapcat #(repeat n %) s))
(deftest test-33
  (testing "#33"
    (is (= (func-33 [1 2 3] 2) '(1 1 2 2 3 3)))
    (is (= (func-33 [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
    (is (= (func-33 [4 5 6] 1) '(4 5 6)))
    (is (= (func-33 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (func-33 [44 33] 2) [44 44 33 33]))))
