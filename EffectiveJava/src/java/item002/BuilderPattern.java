package java.item002;

public class BuilderPattern {

	// 氏名：必須項目
	private String name = null;
	// 住所：任意項目
	private String address = null;
	// 電話番号
	private String tel = null;

	// コンストラクタはプライベートに設定
	private BuilderPattern(Builder builder) {
		this.name = builder.name;
		this.address = builder.address;
		this.tel = builder.tel;
	}

	// 内部クラスとしてBuilderを定義
	public static class Builder {
		// 必須
		private String name = null;

		// 任意
		private String address = null;
		private String tel = null;

		public BuilderPattern build() {
			return new BuilderPattern(this);
		}

		public Builder(String name) {
			this.name = name;
		}

		public Builder setAddress(String val) {
			address = val;
			return this;
		}

		public Builder setTel(String val) {
			tel = val;
			return this;
		}

	}
}
