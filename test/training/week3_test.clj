(ns training.week3-test
  (:require [clojure.test :refer :all]))

;;;; WEEK  3  ============================================================
;;;  DAY   1  ------------------------------------------------------------

;; #95
;; (= (__ '(:a (:b nil nil) nil)) true)
;; (= (__ '(:a (:b nil nil))) false)
;; (= (__ [1 nil [2 [3 nil nil] [4 nil nil]]]) true)
;; (= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]]) false)
;; (= (__ [1 [2 [3 [4 nil nil] nil] nil] nil]) true)
;; (= (__ [1 [2 [3 [4 false nil] nil] nil] nil]) false)
;; (= (__ '(:a nil ())) false)
(defn bintree? [s]
  (or (nil? s) 
      (and (sequential? s) 
           (= 3 (count s)) 
           (every? bintree? (rest s)))))
(def func-95 bintree?)
(deftest test-95
  (testing "#95"
    (is (= (func-95 '(:a (:b nil nil) nil)) true))
    (is (= (func-95 '(:a (:b nil nil))) false))
    (is (= (func-95 [1 nil [2 [3 nil nil] [4 nil nil]]]) true))
    (is (= (func-95 [1 [2 nil nil] [3 nil nil] [4 nil nil]]) false))
    (is (= (func-95 [1 [2 [3 [4 nil nil] nil] nil] nil]) true))
    (is (= (func-95 [1 [2 [3 [4 false nil] nil] nil] nil]) false))
    (is (= (func-95 '(:a nil ())) false))))


;; #96
;; (= (__ '(:a (:b nil nil) (:b nil nil))) true)
;; (= (__ '(:a (:b nil nil) nil)) false)
;; (= (__ '(:a (:b nil nil) (:c nil nil))) false)
;; (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
;;           [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
;;    true)
;; (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
;;           [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
;;    false)
;; (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
;;           [2 [3 nil [4 [6 nil nil] nil]] nil]])
;;    false)
(defn symmetric-bintree? 
  ([s] (symmetric-bintree? (second s) (last s)))
  ([a b] (or 
           (and  (nil? a) (nil? b))
           (if (and (sequential? a) (sequential? b)) 
             (and (= 3 (count a) (count b)) 
                  (= (first a) (first b)) 
                  (symmetric-bintree? (second a) (last b)) 
                  (symmetric-bintree? (last a) (second b)))
             false))))
(def func-96 symmetric-bintree?)
(deftest test-96
  (testing "#96"
    (is (= (func-96 '(:a (:b nil nil) (:b nil nil))) true))
    (is (= (func-96 '(:a (:b nil nil) nil)) false))
    (is (= (func-96 '(:a (:b nil nil) (:c nil nil))) false))
    (is (= (func-96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]] 
                       [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]]) 
           true))
    (is (= (func-96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]] 
                     [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]]) 
           false))
    (is (= (func-96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]] 
                     [2 [3 nil [4 [6 nil nil] nil]] nil]]) 
           false))))


;;;  DAY   2  ------------------------------------------------------------

;; #46
;; (= 3 ((__ nth) 2 [1 2 3 4 5]))
;; (= true ((__ >) 7 8))
;; (= 4 ((__ quot) 2 8))
;; (= [1 2 3] ((__ take) [1 2 3 4 5] 3))
(defn func-46 [f]
  (fn [& args]
    (apply f (reverse args))))
(deftest test-46
  (testing "#46"
    (is (= 3 ((func-46 nth) 2 [1 2 3 4 5])))
    (is (= true ((func-46 >) 7 8)))
    (is (= 4 ((func-46 quot) 2 8)))
    (is (= [1 2 3] ((func-46 take) [1 2 3 4 5] 3)))))


;; #44
;; (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
;; (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
;; (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
;; (= (__ 1 '(:a :b :c)) '(:b :c :a))
;; (= (__ -4 '(:a :b :c)) '(:c :a :b))
(defn func-44 [n s]
    (let [n (mod n (count s))]
      (concat (drop n s) (take n s))))
(deftest test-44
  (testing "#44"
    (is (= (func-44 2 [1 2 3 4 5]) '(3 4 5 1 2)))
    (is (= (func-44 -2 [1 2 3 4 5]) '(4 5 1 2 3)))
    (is (= (func-44 6 [1 2 3 4 5]) '(2 3 4 5 1)))
    (is (= (func-44 1 '(:a :b :c)) '(:b :c :a)))
    (is (= (func-44 -4 '(:a :b :c)) '(:c :a :b)))))
