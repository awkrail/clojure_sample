; defは「値に名前をつける」的なニュアンスで利用している。
(def b-size 8) ; いっぺんのサイズ
(def first-pos 0) ; 先頭のますのpos
(def last-pos (* b-size b-size))
(def all-pos (range first-pos last-pos)) ; 全てのposからなるリスト

(def first-col 0) ; 先頭の桁インデックス
(def last-col b-size) ; 最後の桁インデックス
(def first-row 0) ; 先頭の行インデックス
(def last-row b-size) ; 最後の行インデックス

; positionから行と列を特定する関数
(defn col-from-pos [pos] (mod pos b-size))
(defn row-from-pos [pos] (quot pos b-size))
(defn pos-from-rowcol [r c] (+ (* r b-size) c))

; 方位
(def dirs #{:n :ne :e :se :s :sw :w :nw}) ; #{}はsetで,重複を許さないもの。

(def board (ref [])) 
; 盤面状態ベクタ? ref? refは値への参照
(def player (ref nil))
; 参照は変えることができるっぽい => mutableなオブジェクト
