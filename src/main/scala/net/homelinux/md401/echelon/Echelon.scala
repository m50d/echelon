package net.homelinux.md401.echelon

import shapeless._

object Echelon {
	def solve[MT <: HList](matrix: MT) = matrix
}