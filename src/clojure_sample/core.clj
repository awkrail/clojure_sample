(ns clojure-sample.core
  (:use
    clojure-sample.view
    clojure-sample.model))

(defn on-command
  [cmdline] ; defnのあとに一つコレクションがくる感じらしい
  (let [cmd (first cmdline)
        pos (second cmdline)
        ]
    (cond
      (= cmd :move) (play-move pos)
      (= cmd :exit) (System/exit 0)
      :else nil)))

(defn -main
  [& args]
  (init-view on-command)
  (init-game on-state-changed)
  (start-ui))
