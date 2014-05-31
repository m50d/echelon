package net.homelinux.md401.echelon

import shapeless._

trait IsReducedEchelonForm[MT]

object IsReducedEchelonForm {
  implicit object EmptyIsReducedEchelonForm extends IsReducedEchelonForm[HNil]

  implicit def AddRowReducedEchelonForm[RT <: HNil] = new IsReducedEchelonForm[RT] {}
}

object Echelon {

  def solve[MT <: HList](matrix: MT)(implicit w: IsReducedEchelonForm[MT]) = matrix
}