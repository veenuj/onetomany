package com.onetoMany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="instructor_detail")
public class profileInstructor {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youTubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail", cascade = CascadeType.ALL)
	private instructorDetail instructor;
	
	public profileInstructor() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYouTubeChannel() {
		return youTubeChannel;
	}

	public void setYouTubeChannel(String youTubeChannel) {
		this.youTubeChannel = youTubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public instructorDetail getInstructor() {
		return instructor;
	}

	public void setInstructor(instructorDetail instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "profileInstructor [id=" + id + ", youTubeChannel=" + youTubeChannel + ", hobby=" + hobby
				+ ", instructor=" + instructor + "]";
	}

	public profileInstructor(String youTubeChannel, String hobby) {
		super();
		this.youTubeChannel = youTubeChannel;
		this.hobby = hobby;
	}
}
