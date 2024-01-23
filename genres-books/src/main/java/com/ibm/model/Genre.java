package com.ibm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="genres")
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="genre_id")
	private int genreId;
	
	@Column(name="genre_name")
	private String  genreName;
	
	@Column(name="shelf_no")
	private String shelfNo;
	
	@OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
	private List<Book> books;

	public Genre(String genreName, String shelfNo) {
		super();
		this.genreName = genreName;
		this.shelfNo = shelfNo;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + ", shelfNo=" + shelfNo + "]";
	}
	
	
}
