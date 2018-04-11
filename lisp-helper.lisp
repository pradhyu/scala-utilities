(defun get-file (filename)
  (with-open-file (stream filename)
    (loop for line = (read-line stream nil)
          while line
          collect line)))

(defun read-file-as-lisp-obj (filename)
  (with-open-file (stream filename) 
    (read filename)))


(get-file "src/main/scala/lisp-test.lisp")

