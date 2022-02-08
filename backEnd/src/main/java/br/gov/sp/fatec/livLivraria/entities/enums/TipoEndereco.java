package br.gov.sp.fatec.livLivraria.entities.enums;

public enum TipoEndereco {
		
		CASA(1, "Casa"),
		CASA_GEMINADA(2, "Casa Geminada"),
		SOBRADO(3, "Sobrado"),
		BANGALÔ(4, "Bangalô"),
		MANSÃO(5, "Mansão"),
		EDÍCULA(6, "Edícula"),
		LOFT(7, "Loft"),
		APARTAMENTO_PADRAO(8, "Apartamento Padrão"),
		COBERTURA(9, "Cobertura"),
		GARDEN(10, "Garden"),
		KITNET(11, "Kitnet"),
		STUDIO(12, "Studio"),
		DUPLEX(13, "Duplex"),
		TRIPLEX(14, "Triplex"),
		LOJA(15, "Loja"),
		GALPAO(16, "Galpão");
		
		private Integer valorNumerico;
		private String descricao;
		
		private TipoEndereco(Integer valorNumerico, String descricao) {
			this.valorNumerico = valorNumerico;
			this.descricao = descricao;
		}

		public Integer getValorNumerico() {
			return valorNumerico;
		}

		public String getDescricao() {
			return descricao;
		}
		
		public static TipoEndereco valorToEnum(Integer valorNumerico) {
			if (valorNumerico == null) {
				return null;
			}
			for (TipoEndereco tipo : TipoEndereco.values()) {
				if (valorNumerico == tipo.getValorNumerico()) {
					return tipo;
				}
			}		
			throw new IllegalArgumentException("Valor inválido: " + valorNumerico);
		}

	}


