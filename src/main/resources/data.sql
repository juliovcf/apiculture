begin;

insert into "nationality" ("name") values ('Afghan'), ('Albanian'), ('Algerian'), ('American'), ('Andorran'), ('Angolan'), ('Antiguans'), ('Argentinean'), ('Armenian'), ('Australian'), ('Austrian'), ('Azerbaijani'), ('Bahamian'), ('Bahraini'), ('Bangladeshi'), ('Barbadian'), ('Barbudans'), ('Batswana'), ('Belarusian'), ('Belgian'), ('Belizean'), ('Beninese'), ('Bhutanese'), ('Bolivian'), ('Bosnian'), ('Brazilian'), ('British'), ('Bruneian'), ('Bulgarian'), ('Burkinabe'), ('Burmese'), ('Burundian'), ('Cambodian'), ('Cameroonian'), ('Canadian'), ('Cape Verdean'), ('Central African'), ('Chadian'), ('Chilean'), ('Chinese'), ('Colombian'), ('Comoran'), ('Congolese'), ('Congolese'), ('Costa Rican'), ('Croatian'), ('Cuban'), ('Cypriot'), ('Czech'), ('Danish'), ('Djibouti'), ('Dominican'), ('Dominican'), ('Dutch'), ('Dutchman'), ('Dutchwoman'), ('East Timorese'), ('Ecuadorean'), ('Egyptian'), ('Emirian'), ('Equatorial Guinean'), ('Eritrean'), ('Estonian'), ('Ethiopian'), ('Fijian'), ('Filipino'), ('Finnish'), ('French'), ('Gabonese'), ('Gambian'), ('Georgian'), ('German'), ('Ghanaian'), ('Greek'), ('Grenadian'), ('Guatemalan'), ('Guinea-Bissauan'), ('Guinean'), ('Guyanese'), ('Haitian'), ('Herzegovinian'), ('Honduran'), ('Hungarian'), ('I-Kiribati'), ('Icelander'), ('Indian'), ('Indonesian'), ('Iranian'), ('Iraqi'), ('Irish'), ('Irish'), ('Israeli'), ('Italian'), ('Ivorian'), ('Jamaican'), ('Japanese'), ('Jordanian'), ('Kazakhstani'), ('Kenyan'), ('Kittian and Nevisian'), ('Kuwaiti'), ('Kyrgyz'), ('Laotian'), ('Latvian'), ('Lebanese'), ('Liberian'), ('Libyan'), ('Liechtensteiner'), ('Lithuanian'), ('Luxembourger'), ('Macedonian'), ('Malagasy'), ('Malawian'), ('Malaysian'), ('Maldivan'), ('Malian'), ('Maltese'), ('Marshallese'), ('Mauritanian'), ('Mauritian'), ('Mexican'), ('Micronesian'), ('Moldovan'), ('Monacan'), ('Mongolian'), ('Moroccan'), ('Mosotho'), ('Motswana'), ('Mozambican'), ('Namibian'), ('Nauruan'), ('Nepalese'), ('Netherlander'), ('New Zealander'), ('Ni-Vanuatu'), ('Nicaraguan'), ('Nigerian'), ('Nigerien'), ('North Korean'), ('Northern Irish'), ('Norwegian'), ('Omani'), ('Pakistani'), ('Palauan'), ('Panamanian'), ('Papua New Guinean'), ('Paraguayan'), ('Peruvian'), ('Polish'), ('Portuguese'), ('Qatari'), ('Romanian'), ('Russian'), ('Rwandan'), ('Saint Lucian'), ('Salvadoran'), ('Samoan'), ('San Marinese'), ('Sao Tomean'), ('Saudi'), ('Scottish'), ('Senegalese'), ('Serbian'), ('Seychellois'), ('Sierra Leonean'), ('Singaporean'), ('Slovakian'), ('Slovenian'), ('Solomon Islander'), ('Somali'), ('South African'), ('South Korean'), ('Spanish'), ('Sri Lankan'), ('Sudanese'), ('Surinamer'), ('Swazi'), ('Swedish'), ('Swiss'), ('Syrian'), ('Taiwanese'), ('Tajik'), ('Tanzanian'), ('Thai'), ('Togolese'), ('Tongan'), ('Trinidadian or Tobagonian'), ('Tunisian'), ('Turkish'), ('Tuvaluan'), ('Ugandan'), ('Ukrainian'), ('Uruguayan'), ('Uzbekistani'), ('Venezuelan'), ('Vietnamese'), ('Welsh'), ('Yemenite'), ('Zambian'), ('Zimbabwean');

insert into "status" ("name") values ('BAJA'), ('ALTA'), ('BAJA TEMPORAL');

insert into "role" ("name") values ('ADMIN'), ('MANTAINER'), ('DEVELOPER');

delete from "nationality" main
where main."id" <> (
  select min(aux."id")
  from "nationality" aux
  where main."name" = aux."name"
);

delete from "status" main
where main."id" <> (
  select min(aux."id")
  from "status" aux
  where main."name" = aux."name"
);

delete from "role" main
where main."id" <> (
  select min(aux."id")
  from "role" aux
  where main."name" = aux."name"
);

do $$
declare maxid int;
begin
    select max(id) + 1 from "nationality" into maxid;
    execute 'alter sequence nationality_id_seq restart with ' || maxid;
end;
$$ language plpgsql;

do $$
declare maxid int;
begin
    select max(id) + 1 from "status" into maxid;
    execute 'alter sequence status_id_seq restart with ' || maxid;
end;
$$ language plpgsql;

do $$
declare maxid int;
begin
    select max(id) + 1 from "role" into maxid;
    execute 'alter sequence role_id_seq restart with ' || maxid;
end;
$$ language plpgsql;

commit;
