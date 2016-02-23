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


;;;  DAY   3  ------------------------------------------------------------


;; #107
;; (= 256 ((__ 2) 16) ((__ 8) 2))
;; (= [1 8 27 64] (map (__ 3) [1 2 3 4]))
;; (= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4]))
;; ANSWER: (fn [n] #((fn [x n] (reduce * (repeat n x))) % n))
(defn exp [x n]
  (reduce * (repeat n x)))
(defn func-107 [n]
  #(exp % n))
(deftest test-107
  (testing "#107"
    (is (= 256 ((func-107 2) 16) ((func-107 8) 2)))
    (is (= [1 8 27 64] (map (func-107 3) [1 2 3 4])))
    (is (= [1 2 4 8 16] (map #((func-107 %) 2) [0 1 2 3 4])))))


;; #90
;; (= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
;;    #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
;;      ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
;;      ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})
;; (= (__ #{1 2 3} #{4 5})
;;    #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})
;; (= 300 (count (__ (into #{} (range 10))
;;                   (into #{} (range 30)))))
(defn func-90 [a b]
  (set (for [x a
             y b]
         [x y])))
(deftest test-90
  (testing "#90"
    (is (= (func-90 #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"}) 
           #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"] 
             ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"] 
             ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))
    (is (= (func-90 #{1 2 3} #{4 5}) 
           #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
    (is (= 300 (count (func-90 (into #{} (range 10)) 
                          (into #{} (range 30))))))))



;;;  DAY   4  ------------------------------------------------------------

;; #88
;; (= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
;; (= (__ #{:a :b :c} #{}) #{:a :b :c})
;; (= (__ #{} #{4 5 6}) #{4 5 6})
;; (= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})
(defn func-88 [a b]
  (clojure.set/union (clojure.set/difference a b) (clojure.set/difference b a)))
(deftest test-88
  (testing "#88"
    (is (= (func-88 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))
    (is (= (func-88 #{:a :b :c} #{}) #{:a :b :c}))
    (is (= (func-88 #{} #{4 5 6}) #{4 5 6}))
    (is (= (func-88 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}))))

;; #100
;; (== (__ 2 3) 6)
;; (== (__ 5 3 7) 105)
;; (== (__ 1/3 2/5) 2)
;; (== (__ 3/4 1/6) 3/2)
;; (== (__ 7 5/7 2 3/5) 210)
;; ANSWER: contracted version without defn
;; (fn lcm
;;   ([x y] (/ (* x y) 
;;             ((fn gcd [x y] 
;;                (if (zero? y) 
;;                  x 
;;                  (recur y (mod x y)))) x y))) 
;;   ([x y & rest] (apply lcm (lcm x y) rest)))
(defn gcd [x y]
  (if (zero? y)
    x
    (recur y (mod x y))))
(defn lcm 
  ([x y] (/ (* x y) (gcd x y)))
  ([x y & rest] (apply lcm (lcm x y) rest)))
(defn func-100 [& args]
  (apply lcm args))
(deftest test-100
  (testing "#100"
    (is (== (func-100 2 3) 6))
    (is (== (func-100 5 3 7) 105))
    (is (== (func-100 1/3 2/5) 2))
    (is (== (func-100 3/4 1/6) 3/2))
    (is (== (func-100 7 5/7 2 3/5) 210))))


;;;  DAY   5  ------------------------------------------------------------

;; #97
;; (= (__ 1) [1])
;; (= (__ 11) [1 10 45 120 210 252 210 120 45 10 1])
;; (= (map __ (range 1 6))
;;    [     [1]
;;         [1 1]
;;        [1 2 1]
;;       [1 3 3 1]
;;      [1 4 6 4 1]])
(defn func-97 [n]
  (loop [level 1
         v [1]]
    (if (= level n)
      v
      (recur (inc level)
             (mapv #(apply + %) 
                  (partition 2 1 
                             (mapv + (cons 0 (conj v 0)))))))))
(deftest test-97
  (testing "#97"
    (is (= (func-97 1) [1]))
    (is (= (func-97 2) [1 1]))
    (is (= (func-97 3) [1 2 1]))
    (is (= (func-97 11) [1 10 45 120 210 252 210 120 45 10 1]))
    (is (= (map func-97 (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]]))))
