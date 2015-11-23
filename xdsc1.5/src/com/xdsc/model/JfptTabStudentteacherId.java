package com.xdsc.model;

/**
 * JfptTabStudentteacherId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JfptTabStudentteacherId implements java.io.Serializable {

	// Fields

	private Integer FInt;
	private String FCourseNumber;
	private String FStudentNumber;
	private String FClassNumber;
	private String FTeacherNumber;

	// Constructors

	/** default constructor */
	public JfptTabStudentteacherId() {
	}

	/** minimal constructor */
	public JfptTabStudentteacherId(Integer FInt) {
		this.FInt = FInt;
	}

	/** full constructor */
	public JfptTabStudentteacherId(Integer FInt, String FCourseNumber,
			String FStudentNumber, String FClassNumber, String FTeacherNumber) {
		this.FInt = FInt;
		this.FCourseNumber = FCourseNumber;
		this.FStudentNumber = FStudentNumber;
		this.FClassNumber = FClassNumber;
		this.FTeacherNumber = FTeacherNumber;
	}

	// Property accessors

	public Integer getFInt() {
		return this.FInt;
	}

	public void setFInt(Integer FInt) {
		this.FInt = FInt;
	}

	public String getFCourseNumber() {
		return this.FCourseNumber;
	}

	public void setFCourseNumber(String FCourseNumber) {
		this.FCourseNumber = FCourseNumber;
	}

	public String getFStudentNumber() {
		return this.FStudentNumber;
	}

	public void setFStudentNumber(String FStudentNumber) {
		this.FStudentNumber = FStudentNumber;
	}

	public String getFClassNumber() {
		return this.FClassNumber;
	}

	public void setFClassNumber(String FClassNumber) {
		this.FClassNumber = FClassNumber;
	}

	public String getFTeacherNumber() {
		return this.FTeacherNumber;
	}

	public void setFTeacherNumber(String FTeacherNumber) {
		this.FTeacherNumber = FTeacherNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JfptTabStudentteacherId))
			return false;
		JfptTabStudentteacherId castOther = (JfptTabStudentteacherId) other;

		return ((this.getFInt() == castOther.getFInt()) || (this.getFInt() != null
				&& castOther.getFInt() != null && this.getFInt().equals(
				castOther.getFInt())))
				&& ((this.getFCourseNumber() == castOther.getFCourseNumber()) || (this
						.getFCourseNumber() != null
						&& castOther.getFCourseNumber() != null && this
						.getFCourseNumber()
						.equals(castOther.getFCourseNumber())))
				&& ((this.getFStudentNumber() == castOther.getFStudentNumber()) || (this
						.getFStudentNumber() != null
						&& castOther.getFStudentNumber() != null && this
						.getFStudentNumber().equals(
								castOther.getFStudentNumber())))
				&& ((this.getFClassNumber() == castOther.getFClassNumber()) || (this
						.getFClassNumber() != null
						&& castOther.getFClassNumber() != null && this
						.getFClassNumber().equals(castOther.getFClassNumber())))
				&& ((this.getFTeacherNumber() == castOther.getFTeacherNumber()) || (this
						.getFTeacherNumber() != null
						&& castOther.getFTeacherNumber() != null && this
						.getFTeacherNumber().equals(
								castOther.getFTeacherNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFInt() == null ? 0 : this.getFInt().hashCode());
		result = 37
				* result
				+ (getFCourseNumber() == null ? 0 : this.getFCourseNumber()
						.hashCode());
		result = 37
				* result
				+ (getFStudentNumber() == null ? 0 : this.getFStudentNumber()
						.hashCode());
		result = 37
				* result
				+ (getFClassNumber() == null ? 0 : this.getFClassNumber()
						.hashCode());
		result = 37
				* result
				+ (getFTeacherNumber() == null ? 0 : this.getFTeacherNumber()
						.hashCode());
		return result;
	}

}