package net.homelinux.md401.echelon

import shapeless.HList

object Echelon {
	def solve[MT <: HList](matrix: MT) = matrix
}