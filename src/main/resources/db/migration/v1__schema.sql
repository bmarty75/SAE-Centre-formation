CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE department (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  code VARCHAR(50) UNIQUE NOT NULL,
  label TEXT NOT NULL,
  parent_id UUID
);

CREATE TABLE app_user (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  email TEXT UNIQUE NOT NULL,
  password_hash TEXT NOT NULL,
  display_name TEXT NOT NULL,
  phone TEXT,
  role TEXT NOT NULL,
  status TEXT NOT NULL DEFAULT 'ACTIF',
  department_id UUID REFERENCES department(id),
  created_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE competency (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  code VARCHAR(50) UNIQUE NOT NULL,
  title TEXT NOT NULL
);

CREATE TABLE ue (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  department_id UUID REFERENCES department(id),
  code VARCHAR(50) NOT NULL,
  title TEXT NOT NULL,
  semester INT NOT NULL,
  objectifs TEXT
);

CREATE TABLE ec (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  ue_id UUID REFERENCES ue(id),
  title TEXT NOT NULL,
  cm_hours NUMERIC(5,2) DEFAULT 0,
  td_hours NUMERIC(5,2) DEFAULT 0,
  tp_hours NUMERIC(5,2) DEFAULT 0,
  cm_hours_alt NUMERIC(5,2),
  td_hours_alt NUMERIC(5,2),
  tp_hours_alt NUMERIC(5,2)
);

CREATE TABLE sae (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  ue_id UUID REFERENCES ue(id),
  title TEXT NOT NULL,
  description TEXT
);

CREATE TABLE resource_sheet (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  department_id UUID REFERENCES department(id),
  ue_id UUID REFERENCES ue(id),
  ec_id UUID REFERENCES ec(id),
  sae_id UUID REFERENCES sae(id),
  status TEXT NOT NULL DEFAULT 'DRAFT',
  objectives TEXT,
  prerequisites TEXT,
  modalities TEXT,
  hours_cm NUMERIC(5,2) DEFAULT 0,
  hours_td NUMERIC(5,2) DEFAULT 0,
  hours_tp NUMERIC(5,2) DEFAULT 0,
  responsible_id UUID REFERENCES app_user(id),
  archivable_year INT,
  version INT NOT NULL DEFAULT 0,
  created_at TIMESTAMP NOT NULL DEFAULT now(),
  updated_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE resource_sheet_competency (
  resource_sheet_id UUID REFERENCES resource_sheet(id) ON DELETE CASCADE,
  competency_id UUID REFERENCES competency(id),
  PRIMARY KEY (resource_sheet_id, competency_id)
);

CREATE TABLE tac_entry (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  department_id UUID REFERENCES department(id),
  date DATE NOT NULL,
  observation TEXT NOT NULL,
  origine TEXT,
  thematique TEXT,
  correction TEXT,
  analyse TEXT,
  action TEXT,
  echeance DATE,
  statut TEXT,
  commentaire TEXT
);