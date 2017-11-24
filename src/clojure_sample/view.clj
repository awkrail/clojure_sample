(ns clojure_sample.view
  (:use
    clojure_sample.model
    [clojure.string :only (join)]))

(def code-a 97) ; \aの文字コード
(def code-curly 123) ; \zの次の文字コード
(def col-headers
  (take b-size
        (map (comp str char)
             (range code-a code-curly))))

(def col-header-str
  (str " " (join " " col-headers)))

(defn- st-str ; defn-はprivateな関数である。
  "マスの状態を表す文字列"
  [st]
  (cond
    (= st :b) "×"
    (= st :w) "○"
    :else " " ))

(defn- board-strs
  "文字列シーケンス/ボードの各行をレンダリングしたもの"
  [brd]
  (for [row (partition b-size brd)] ; ベクタからN個だけ取り出すにはpartitionが使える
    (join " " (map st-str row))))

(defn- board-strs-with-row
  "board-strsに行番号を付加したもの"
  [brd]
  (map str
       (range (inc first-row) (inc last-row))
       (repeat b-size " ")
       (board-strs brd))) ; map strで, 各リストの一つずつの要素をくっつけるstr関数を利用する

