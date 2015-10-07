package za.ac.cput.libapp.app.model;

/**
 * Created by Yongama on 2015-05-19.
 */
public class Member {

    private Long id;


    private String member_id;

    private String firstName;
    private String lastName;

    private Address address;

    private Member(){}
    public Member(Builder builder){
        this.id = builder.id;
        member_id = builder.member_id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
    }


    public Long getId() {
        return id;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }


    public static class Builder{
        private Long id;
        private String member_id;
        private String firstName;
        private String lastName;
        private Address address;

        public Builder(String value){
            this.member_id = value;
        }

        public Builder firstName(String value){
            this.firstName = value;
            return this;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder lastName(String value){
            this.lastName = value;
            return this;
        }

        public Builder Address(Address value){
            this.address = value;
            return this;
        }

        public Builder copy(Member value){
            this.member_id = value.member_id;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            this.address = value.address;
            this.id = value.id;
            return this;
        }

        public Member build(){
            return new Member(this);
        }
    }
}
