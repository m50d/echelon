package net.homelinux.md401.echelon

import shapeless._
import scala.None

trait ColumnExtension[MT] {
  type Extended <: HNil
}

object ColumnExtension {
  implicit object EmptyColumnExtension extends ColumnExtension[HNil] {
    type Extended = HNil
  }
  
  implicit def AddRowColumnExtension[RT <: HNil, TT <: HNil, ETT <: HNil] = new ColumnExtension[RT :: TT] {
    type Extended = (Int :: RT) :: ETT
  }
}

trait IsReducedEchelonForm[MT]

object IsReducedEchelonForm {
  implicit object EmptyIsReducedEchelonForm extends IsReducedEchelonForm[HNil]

  implicit def AddRowReducedEchelonForm[TT <: HNil] = new IsReducedEchelonForm[TT] {}
}

object Echelon {

  def solve[MT <: HList](matrix: MT)(implicit w: IsReducedEchelonForm[MT]) = matrix
}